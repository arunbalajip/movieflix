var gulp = require('gulp'),
    clean = require('gulp-clean'),
    inject = require('gulp-inject'),
    bowerFiles = require('main-bower-files'),
    angularFileSort = require('gulp-angular-filesort'),
    filter = require('gulp-filter'),
    concat = require('gulp-concat'),
    cleanCss = require('gulp-clean-css'),
    uglify = require('gulp-uglify'),
    merge = require('merge-stream'),
    browserSync = require('browser-sync').create();

var config = {
    paths: {
        src: './src',
        build: './build',
        bower: './bower_components'
    }
};

gulp.task('clean', function () {
    return gulp.src(config.paths.build, {read: false})
        .pipe(clean());
});

gulp.task('inject', function () {

    var cssFiles = gulp.src([
        config.paths.src + '/**/*.css'
    ], {read: false});

    var jsFiles = gulp.src([
        config.paths.src + '/**/*.js'
    ]);

    return gulp.src(config.paths.src + '/index.html')
        .pipe(inject(gulp.src(bowerFiles(), {read: false}), {name: 'bower'}))
        .pipe(inject(cssFiles, {ignorePath: 'src', addRootSlash: false}))
        .pipe(inject(jsFiles.pipe(angularFileSort()), {ignorePath: 'src', addRootSlash: false}))
        .pipe(gulp.dest(config.paths.build));
});

gulp.task('serve', ['inject'], function () {
    browserSync.init({
        server: {
            baseDir: [config.paths.build, config.paths.bower, config.paths.src],
            routes: {
                '/bower_components': 'bower_components'
            }
        },
        files: [
            config.paths.src + '/**'
        ]
    });
});


gulp.task('minifyCss', function () {
    var vendorStyles = gulp.src(bowerFiles())
        .pipe(filter(['**/*.css']))
        .pipe(concat('vendor.min.css'))
        .pipe(cleanCss({debug: true, compatibility: 'ie8'}))
        .pipe(gulp.dest(config.paths.build + '/styles'));

    var appStyles = gulp.src(config.paths.src + '/**/*.css')
        .pipe(concat('app.min.css'))
        .pipe(cleanCss({debug: true, compatibility: 'ie8'}))
        .pipe(gulp.dest(config.paths.build + '/styles'));

    return merge(vendorStyles, appStyles);
});

gulp.task('minifyJs', function () {
    var vendorScripts = gulp.src(bowerFiles())
        .pipe(filter(['**/*.js']))
        .pipe(concat('vendor.min.js'))
        .pipe(uglify())
        .pipe(gulp.dest(config.paths.build + '/scripts'));

    var appScripts = gulp.src(config.paths.src + '/**/*.js')
        .pipe(angularFileSort())
        .pipe(concat('app.min.js'))
        .pipe(uglify())
        .pipe(gulp.dest(config.paths.build + '/scripts'));

    return merge(vendorScripts, appScripts);
});

gulp.task('htmls', function () {
    return gulp.src([config.paths.src + '/**/*.html', '!' + config.paths.src + '/index.html'])
        .pipe(gulp.dest(config.paths.build));
});

gulp.task('fonts', function () {
    return gulp.src(bowerFiles())
        .pipe(filter(['**/*.{eot,svg,ttf,woff,woff2}']))
        .pipe(gulp.dest(config.paths.build + '/fonts'));
});

gulp.task('other', function () {
    return gulp.src([config.paths.src + '/**/*.*', '!**/*.html', '!**/*.css', '!**/*.js'])
        .pipe(gulp.dest(config.paths.build));
});

gulp.task('build', ['minifyCss', 'minifyJs', 'htmls', 'fonts', 'other'], function () {

    var vendorFiles = gulp.src([
        config.paths.build + '/styles/vendor.min.css',
        config.paths.build + '/scripts/vendor.min.js'
    ], {read: false});

    var appFiles = gulp.src([
        config.paths.build + '/styles/app.min.css',
        config.paths.build + '/scripts/app.min.js'
    ], {read: false});

    return gulp.src(config.paths.src + '/index.html')
        .pipe(inject(vendorFiles, {name: 'vendor', ignorePath: 'build', addRootSlash: false}))
        .pipe(inject(appFiles, {name: 'app', ignorePath: 'build', addRootSlash: false}))
        .pipe(gulp.dest(config.paths.build));
});
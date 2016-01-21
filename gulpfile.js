/*globals require*/

var gulp = require('gulp'),
    bower = require('gulp-bower'),
    concat = require('gulp-concat'),
    jshint = require('gulp-jshint'),
    less = require('gulp-less'),
    cssmin = require('gulp-minify-css'),
    notify = require('gulp-notify'),
    rename = require('gulp-rename'),
    uglify = require('gulp-uglify'),
    watch = require('gulp-watch'),
    rimraf = require('rimraf');

var path = {
    src: {
        html: 'src/main/webapp/app/html/**/*.html',
        index: 'src/main/webapp/app/index.html',
        js: ['src/main/webapp/app/js/app.js', 'src/main/webapp/app/js/**/*.js'],
        less: 'src/main/webapp/app/less/style.less',
        images: 'src/main/webapp/app/images/**/*.*',
        fonts: 'src/main/webapp/app/fonts/**/*.*',
        root: 'src/main/webapp/app/'
    },
    build: {
        html: 'src/main/webapp/public/html/',
        js: 'src/main/webapp/public/js/',
        css: 'src/main/webapp/public/css/',
        images: 'src/main/webapp/public/images/',
        fonts: 'src/main/webapp/public/fonts/',
        root: 'src/main/webapp/public/'
    },
    vendors: {
        js: [
            'src/main/webapp/bower_components/jquery/dist/jquery.min.js',
            'src/main/webapp/bower_components/angular/angular.min.js',
            'src/main/webapp/bower_components/angular-resource/angular-resource.min.js',
            'src/main/webapp/bower_components/angular-route/angular-route.min.js',
            'src/main/webapp/bower_components/angular-bootstrap/ui-bootstrap.min.js',
            'src/main/webapp/bower_components/angular-ui-router/release/angular-ui-router.min.js'
        ],
        css: [
            'src/main/webapp/bower_components/bootstrap/dist/css/bootstrap.min.css'
        ],
        root: 'src/main/webapp/bower_components/'
    },
    watch: {
        html: 'src/main/webapp/app/html/**/*.html',
        index: 'src/main/webapp/app/index.html',
        js: 'src/main/webapp/app/js/**/*.js',
        less: 'src/main/webapp/less/style.less',
        images: 'src/main/webapp/app/images/**/*.*',
        fonts: 'src/main/webapp/app/fonts/**/*.*'
    }
};

gulp.task('clean', function (cb) {
    return rimraf(path.build.root, cb);
});

gulp.task('bower', function () {
    return bower()
        .pipe(gulp.dest(path.vendors.root));
});

gulp.task('jshint', function () {
    return gulp.src(['gulpfile.js', 'package.json'], path.src.js)
        .pipe(jshint())
        .pipe(jshint.reporter('default'));
});

gulp.task('html:copy', function () {
    return gulp.src([path.src.html])
        .pipe(gulp.dest(path.build.html))
        .pipe(notify({message: 'html:copy task complete'}));
});

gulp.task('index:copy', function () {
    return gulp.src([path.src.index])
        .pipe(gulp.dest(path.build.root))
        .pipe(notify({message: 'index:copy task complete'}));
});

gulp.task('js:build', function () {
    return gulp.src(path.src.js)
        .pipe(concat('build.js'))
        .pipe(gulp.dest(path.build.js))
        .pipe(uglify())
        .pipe(rename({suffix: '.min'}))
        .pipe(gulp.dest(path.build.js))
        .pipe(notify({message: 'js:build task complete'}));
});

gulp.task('vendors-js:build', function () {
    return gulp.src(path.vendors.js)
        .pipe(concat('vendors.js'))
        .pipe(gulp.dest(path.build.js));
});

gulp.task('less:build', function () {
    return gulp.src(path.src.less)
        .pipe(less())
        .pipe(gulp.dest(path.build.css))
        .pipe(cssmin())
        .pipe(rename({suffix: '.min'}))
        .pipe(gulp.dest(path.build.css))
        .pipe(notify({message: 'less:build task complete'}));
});

gulp.task('vendors-css:build', function () {
    return gulp.src(path.vendors.css)
        .pipe(gulp.dest(path.build.css));
});

gulp.task('watch', function () {
    gulp.watch(path.watch.html, ['html:copy']);
    gulp.watch(path.watch.index, ['index:copy']);
    gulp.watch(path.watch.js, ['js:build']);
    gulp.watch(path.watch.less, ['less:build']);
});

gulp.task('copy', [
    'html:copy',
    'index:copy'
]);

gulp.task('vendors:build', [
    'vendors-js:build',
    'vendors-css:build'
]);

gulp.task('build', [
    'js:build',
    'less:build',
    'vendors:build'
]);

gulp.task('default', ['bower', 'jshint', 'clean'], function () {
    gulp.start('copy', 'build', 'watch');
});
var path = require('path');

module.exports = {
    entry: './src/main/js/app.js',
    output: {
        path: __dirname,
        filename: './src/main/resources/static/built/bundle.js'
    },
    mode: 'development',
};
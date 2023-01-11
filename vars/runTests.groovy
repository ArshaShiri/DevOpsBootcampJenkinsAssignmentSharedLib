def call() {
    // Enter app directory where all the related files are located.
    dir("app") {
        sh "npm install"
        sh "npm run test"
    }
}
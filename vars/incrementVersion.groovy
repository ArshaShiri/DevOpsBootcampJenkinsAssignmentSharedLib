def call() {
    // Enter app directory where all the related files are located.
    dir("app") {
        // Increment the minor version. Choices are: patch, minor or major
        sh "npm version minor"

        def jsonPackage = readJSON file: 'package.json'
        def appVersion = jsonPackage.version
        echo "version is incremented to ${appVersion}"

        env.IMAGE_NAME = "$appVersion-$BUILD_NUMBER"
        echo "Docker image name is ${env.IMAGE_NAME}"
    }
}
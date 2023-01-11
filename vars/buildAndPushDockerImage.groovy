def call() {
    withCredentials([usernamePassword(credentialsId: 'docker-credentials', usernameVariable: 'USER', passwordVariable: 'PWD')]){
        sh "docker build -t arshashiri/demo-app:${IMAGE_NAME} ."
        sh "echo ${PWD} | docker login -u ${USER} --password-stdin"
        sh "docker push arshashiri/demo-app:${IMAGE_NAME}"
    }
}
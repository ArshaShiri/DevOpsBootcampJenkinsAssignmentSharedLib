def call() {
    withCredentials([usernamePassword(credentialsId: 'git-credentials', usernameVariable: 'USER', passwordVariable: 'PWD')]) {
        // Configure git for the first time.
        sh 'git config --global user.email "jenkins@example.com"'
        sh 'git config --global user.name "jenkins"'

        sh "git remote set-url origin git@github.com:ArshaShiri/DevOpsBootcampJenkinsAssignment.git"
        sh 'git add .'
        sh 'git commit -m "ci: version change"'
        sh 'git push origin HEAD:main'
    }
}
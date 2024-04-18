node("testnode") {
    def targetBranch = 'firstbranch'
    
    def currentBranch = sh(script: 'git rev-parse --abbrev-ref HEAD', returnStdout: true).trim()
    
    if (currentBranch == targetBranch) {
        stage('Clone sources') {
            git branch: 'sourcebranch', url: 'https://github.com/Abhi-chintu/applications-db.git'
        }

        stage('Build') {
            sh 'pip install -r requirements.txt'
        }

        stage('Docker image') {
            sh 'docker build -t abhichintu/python-image:${BUILD_NUMBER} .'
        }

        stage('Docker push') {
            withCredentials([usernamePassword(credentialsId: 'docker-creds', passwordVariable: 'password', usernameVariable: 'username')]) {
                sh '''
                docker login -u ${username} -p ${password}
                docker push abhichintu/python-image:${BUILD_NUMBER}
                '''
            }
        }
    } else {
        echo "Skipping pipeline execution because the current branch (${currentBranch}) does not match the target branch (${targetBranch})."
    }
}

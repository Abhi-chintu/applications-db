node("testnode") {
    stage('Clone sources') {
        git branch: 'master', url: 'https://github.com/Abhi-chintu/applications-db.git'
    }

    stage('Build') {
        sh 'pip install -r requirements.txt'
    }

    stage('Docker image') {
        // Build Docker image only if changes are pushed to the repository
        if (env.CHANGE_ID) {
            sh 'docker build -t abhichintu/python-image:${BUILD_NUMBER} .'
        } else {
            echo "Skipping Docker image build as no changes were pushed to the repository."
        }
    }

    stage('Docker push') {
        // Push Docker image only if changes are pushed to the repository
        if (env.CHANGE_ID) {
            withCredentials([usernamePassword(credentialsId: 'docker-creds', passwordVariable: 'password', usernameVariable: 'username')]) {
                sh '''
                docker login -u ${username} -p ${password}
                docker push abhichintu/python-image:${BUILD_NUMBER}
                '''
            }
        } else {
            echo "Skipping Docker push as no changes were pushed to the repository."
        }
    }
}

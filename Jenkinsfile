node("testnode") {
    stage('Clone sources') {
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], userRemoteConfigs: [[url: 'https://github.com/Abhi-chintu/applications-db.git']]])
    }

    stage('Build') {
        sh 'pip install -r requirements.txt'
    }

    stage('Docker image') {
        sh "docker build -t abhichintu/python-image:${BUILD_NUMBER} ."
    }

    stage('Docker push') {
        withCredentials([usernamePassword(credentialsId: 'docker-creds', passwordVariable: 'password', usernameVariable: 'username')]) {
            sh """
            docker login -u ${username} -p ${password}
            docker push abhichintu/python-image:${BUILD_NUMBER}
            """
        }
    }
    def gitBranch = env.GIT_BRANCH
    if (gitBranch != null && gitBranch.startsWith('refs/tags/')) {
        echo "Tag detected. Building..."
    }
}

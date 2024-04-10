node("testnode"){
    stage('Clone sources') {
       git branch: 'master', url: 'https://github.com/Abhi-chintu/applications-db.git'
    }
    
    stage('build'){
        sh 'pip install -r requirements.txt'
    }
    
    stage('docker image'){
        sh 'docker build -t abhichintu/python-image:${BUILD_NUMBER} .'
    }
    
    stage('docker push') {
        withCredentials([usernamePassword(credentialsId: 'docker-creds', passwordVariable: 'password', usernameVariable: 'username')]) {
            sh '''
            docker login -u ${username} -p ${password}
            docker build -t abhichintu/python-image:${BUILD_NUMBER} .
            docker push abhichintu/python-image:${BUILD_NUMBER}
            '''
        }
    }
}


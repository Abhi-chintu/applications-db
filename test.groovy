def build() {
   sh 'pip install -r requirements.txt'
}

def dockerImageBuild(){
    sh "docker build -t abhichintu/python-image:${BUILD_NUMBER} ."
}

def dockerImagePush(){
    withCredentials([usernamePassword(credentialsId: 'docker-creds', passwordVariable: 'password', usernameVariable: 'username')]) {
            sh """
            docker login -u ${username} -p ${password}
            docker push abhichintu/python-image:${BUILD_NUMBER}
            """
        }
}
return this


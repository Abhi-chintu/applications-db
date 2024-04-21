node("testnode") {
    stage("chekcout") {
       checkout([$class: 'GitSCM', branches: [[name: 'master']], userRemoteConfigs: [[url: 'https://github.com/Abhi-chintu/applications-db.git']]])
       groovyfile = load "test.groovy"
    }
    stage("Build") {
        groovyfile.build()
    }

    stage("Image build"){
         groovyfile.dockerImageBuild()
    }

    stage("Image Push"){
        groovyfile.dockerImagePush()
    }
}

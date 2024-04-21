node("testnode") {
    stage("chekcout") {
       checkout([$class: 'GitSCM', branches: [[name: 'master']], userRemoteConfigs: [[url: 'https://github.com/Abhi-chintu/applications-db.git']]])
    }
    stage("Load groovy"){
    groovyfile = load "test.groovy"
    }
    
    stage("Build") {
        groovyfile.build()
    }
}

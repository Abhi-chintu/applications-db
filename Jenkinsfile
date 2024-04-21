node("testnode") {
    stage("chekcout") {
        
       checkout([$class: 'GitSCM', branches: [[name: 'master']], userRemoteConfigs: [[url: 'https://github.com/Abhi-chintu/applications-db.git']]])
        def groovyfile = load "test.groovy"
    }

    stage("Build") {
        groovyfile.build()
    }
}

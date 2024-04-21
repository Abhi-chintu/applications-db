node("testnode") {
    def test = [
        dependency: ['pull_request', 'branch', 'tag', 'other'],
        build: ['pull_request', 'branch', 'tag', 'other']
    ]

    try {
        if (env.CHANGE_ID) {
            buildType = 'pull_request'
            branchName = env.CHANGE_BRANCH
        }
        if (env.BRANCH_NAME) {
            buildType = 'branch'
            branchName = env.BRANCH_NAME
        }
        if (env.TAG_NAME) {
            buildType = 'tag'
            branchName = env.TAG_NAME
        }

        stage("checkout") {
            if (buildType == 'pull_request') {
                checkout([$class: 'GitSCM', branches: [[name: 'master']], userRemoteConfigs: [[url: 'https://github.com/Abhi-chintu/applications-db.git']]])
            } else {
                echo "Success"
            }
           groovyfile = load "test.groovy"
            // You can use the loaded Groovy file here
        }
    } catch (exc) {
        echo "An exception occurred while testing the packages: ${exc}"
    }
}

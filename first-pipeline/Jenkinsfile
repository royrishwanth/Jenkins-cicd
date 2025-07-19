// groovylint-disable CompileStatic
pipeline {
    agent {
        docker {
            image 'node:16-alpine'
        }
    }
    stages {
        stage('Test Build') {
            steps {
                sh 'node --version'
            }
        }
    }
}


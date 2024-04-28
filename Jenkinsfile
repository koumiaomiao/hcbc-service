pipeline {
    agent any
    triggers {
        pollSCM("H/15 * * * *")
    }
    options {
        buildDiscarder(logRotator(numToKeepStr: '30', artifactNumToKeepStr: '30'))
    }

    stages {
        stage('Clean Env') {
            steps {
                sh './gradlew clean'
            }
        }
        stage('Build Hcbc Jar') {
            options {
                retry(3)
            }
            steps {
                sh './gradlew bootJar'
            }
        }
        stage('Generate and public hcbc-service image') {
            options {
                retry(3)
            }
            steps {
                sh 'docker login -u mjkou@thoughtworks.com -p password.'
                sh 'docker build -t koumiaojuan/hcbc-service:0.0.1-SNAPSHOT .'
                sh 'docker run -p 8088:8088 koumiaojuan/hcbc-service:0.0.1-SNAPSHOT'
            }
        }
    }
}


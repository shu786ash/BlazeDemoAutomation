pipeline {

    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Clean Project') {
            steps {
                bat 'mvn clean'
            }
        }

        stage('Build Project') {
            steps {
                bat 'mvn compile'
            }
        }

        stage('Run TestNG Tests') {
            steps {
                bat 'mvn test'
            }
        }
        stage('Docker Build') {
    steps {
        bat 'docker build -t blazedemo-automation .'
    }
}

stage('Docker Run') {
    steps {
        bat 'docker run --rm blazedemo-automation'
    }
}
    }

    post {

        always {

            archiveArtifacts artifacts: 'screenshots/*.png', allowEmptyArchive: true

            archiveArtifacts artifacts: 'test-output/**/*.*', allowEmptyArchive: true
        }

        success {
            echo 'BlazeDemo Automation Executed Successfully'
        }

        failure {
            echo 'BlazeDemo Automation Failed'
        }
    }
}
pipeline {
    agent any

    // Optional: uncomment after adding JDK21 and Maven3 under Manage Jenkins > Tools.
    // The names must match exactly.
    // tools {
    //     jdk 'JDK21'
    //     maven 'Maven3'
    // }

    triggers {
        // Check Git every 2 minutes for new commits
        pollSCM('H/2 * * * *')
    }

    options {
        timestamps()
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Check Tools') {
            steps {
                sh 'java -version'
                sh 'javac -version'
                sh 'mvn -version'
            }
        }

        stage('Compile') {
            steps {
                sh 'mvn -B -ntp compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn -B -ntp test'
            }
            post {
                always {
                    junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                sh 'mvn -B -ntp package -DskipTests'
            }
        }

        stage('Run') {
            steps {
                sh 'java -jar target/jenkins-maven-demo-1.0-SNAPSHOT.jar'
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        success {
            echo 'BUILD SUCCESS'
        }
        failure {
            echo 'BUILD FAILED - open Console Output and read the first ERROR line'
        }
    }
}

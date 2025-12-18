pipeline {
    agent any

    tools {
        jdk 'Java17'
        maven 'Maven3'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Code checked out'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('SonarQube Analysis') {
            environment {
                SCANNER_HOME = tool 'SonarScanner'
            }
            steps {
                bat "%SCANNER_HOME%\\bin\\sonar-scanner.bat -Dsonar.projectKey=employee-service -Dsonar.sources=src -Dsonar.host.url=http://localhost:9000 -Dsonar.login=squ_176a902ccc21873b96eafa15cb50b027a2b799ea"
            }
        }
    }
}

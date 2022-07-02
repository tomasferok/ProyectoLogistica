pipeline {
  agent {
    node {
      label 'ubuntu-2004'
    }

  }
  stages {
    stage('Build') {
      steps {
        sh 'mvn -B -DskipTests clean package'
        fingerprint '/tmp/workspace/ectoLogistica_feature_despliegue/src/target/**.jar'
      }
    }

    stage('Test') {
      post {
        always {
          junit 'target/surefire-reports/*.xml'
        }

      }
      steps {
        sh 'mvn test'
      }
    }

    stage('Deliver') {
      steps {
        sh './jenkins/scripts/deliver.sh'
      }
    }

  }
  tools {
    maven 'maven'
  }
}
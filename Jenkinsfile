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
        googleStorageUpload(pattern: '/tmp/workspace/ectoLogistica_feature_despliegue/src/target/**.jar', bucket: 'clawtech-logistica-proyecto-jenkins-artifacts', credentialsId: 'gcloud')
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
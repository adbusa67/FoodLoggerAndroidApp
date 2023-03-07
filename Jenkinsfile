pipeline {
  agent none
  stages {
    stage('Print Message') {
      steps {
        echo 'Hello Build'
      }
    }

    stage('Build Job') {
      steps {
        build 'Build'
      }
    }

  }
}
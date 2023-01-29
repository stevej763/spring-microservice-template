#!groovy

String branchName = env.BRANCH_NAME
String buildId = env.BUILD_ID
String jenkinsUrl = env.JENKINS_URL

def setCreds() {
    sh('git config --global user.email "${GIT_USERNAME}@steve.com"')
    sh('git config --global user.name "${GIT_USERNAME}"')
}

node {

    stage('Pipeline Setup') {
        setCreds()
        echo "Running build #${buildId} on ${jenkinsUrl}"
        checkout([
                $class: 'GitSCM',
                branches: [[name: branchName]],
                extensions: [],
                userRemoteConfigs: [
                        [credentialsId: 'jenkins-github',
                         url: 'https://github.com/stevej763/spring-microservice-template.git']
                ]
        ])
    }

    stage('Unit Tests') {
        echo "Testing ${branchName}...."
        withEnv(["PATH+MAVEN=${tool 'Maven'}/bin"]) {
            sh 'mvn test -Dspring.profiles.active=test'
        }
    }

    stage('Build') {
        echo "Building ${branchName}...."
        withEnv(["PATH+MAVEN=${tool 'Maven'}/bin"]) {
            sh 'mvn clean package -DskipTests=true -Dspring.profiles.active=test'
        }
    }

    stage('Integration Tests') {
        echo "Testing ${branchName}...."
        withEnv(["PATH+MAVEN=${tool 'Maven'}/bin"]) {
            sh 'mvn verify -Dspring.profiles.active=test'
        }
    }

}

#!/usr/bin/env groovy

def call() {
    // Referencing Jenkins job global env variable
    echo "building the application for branch $BRANCH_NAME..."
    sh "mvn package"
}
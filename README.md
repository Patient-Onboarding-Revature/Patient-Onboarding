# Patient-Onboarding

## Repository Rules
1. Do not push commits to master: the UAT environment will pull code from master and when a commit is pushed to master it will start the continuous delivery pipeline.
2. Make commits to staging or branches of staging: staging and branches around staging will have continuous integration pipelines to build and test code. Any commit or pull requests will have continuous integration tests performed on them. Pull requests from anywhere to master should also have continuous integration tests.

# Bitingbit's interview projects

# 1. The Challenge

The challenge consists of three projects. A backend, web frontend and android 8 project. The UI's should have two tabs with user profile info and showing news.

# 2. Starting the projects

The bitingbit-news-webapp is used as backend project and the bitingbit-news-webfrontend as the frontend. Therefore you should start the
bitingbit-news-webapp before the frontend.

The Andriod app can be started alone since it isn't connected to any backend yet.

## 2.1. Starting the backend

There are two ways of starting the backend: with or without docker. The backend requires a postgresql database. If you don't have a postgresql installed locally use the first one. Therefore you will need to install
docker locally.

In order to build options see the README.md in bitingbit-news-webapp.

### 1. Starting the backend with postgresql in docker

- Install docker locally. Go to the 'bitingbit-news-webapp' root folder where the docker-compose.yml file is placed and run:

  - docker-compose up -d

- Run the following command in the root directory of bitingbit-news-webapp
  - ./gradlew quarkusDev

### 2. Starting the backend and postgresql seperatly

If you have local postgresql running, it is enough if you just start the
project.

- Run the following command in the root directory of bitingbit-news-webapp
  - ./gradlew quarkusDev

## 2.2 Starting the frontend

- Run the following command in the root directory of bitingbit-news-webfrontend
- yarn install && yarn serve

## 2.3 Starting the andriod app

You need to have android studio and its emulator installed in order to use the app. After installation open the project with android studio
and create a android 8 emulator. Start the emulator and run the app in it by pressing the run button.

# Further Scope

- Implement tests for the implemented modules
- In the future, further sub-areas should be created on the profile tab
- There should be more tabs in the future
- At least the profile data should be saved locally
- REST communication

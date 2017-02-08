cmake_minimum_required(VERSION 3.6)
project(ContestProgramming)

set(CMAKE_CXX_STANDARD 14)

set(SOURCE_FILES FightingTheZombies.cpp manic_moving.cpp beach_umbrellas.cpp)
add_executable(ContestProgramming ${SOURCE_FILES})
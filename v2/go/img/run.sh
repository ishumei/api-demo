#!/bin/bash
# 运行 demo 执行 sh run.sh
BIN_DIR=$(dirname $0)
BIN_DIR=$(cd $BIN_DIR; pwd)
ROOT_DIR=$BIN_DIR

cd $ROOT_DIR
export GOPATH=$ROOT_DIR
export GOBIN=$GOPATH/bin

go install src/main.go  
./bin/main  

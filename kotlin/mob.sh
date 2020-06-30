#!/bin/bash

COMMAND=$1
BRANCH=$2

if [[ "$COMMAND" == "init" ]]
then
    echo "INITIALIZING SESSION '$BRANCH'"
    git fetch --prune
    git pull --ff-only
    git branch $BRANCH
    git checkout $BRANCH
    git push --no-verify --set-upstream origin $BRANCH
elif [[ "$COMMAND" == "start" ]]
then
    echo "STARTING YOUR SESSION ON '$BRANCH'"
    git fetch --prune
    git pull --ff-only
    git checkout -B $BRANCH origin/$BRANCH
    git branch --set-upstream-to=origin/$BRANCH $BRANCH
elif [[ "$COMMAND" == "next" ]]
then
    echo "HANDOVER SESSION TO THE NEXT PERSON ON '$BRANCH'"
    git add --all
    git commit --message "mob next [ci-skip]" --no-verify
    git push --no-verify origin $BRANCH
elif [[ "$COMMAND" == "reset" ]]
then
    echo "RESET SESSION '$BRANCH'"
    git fetch origin
    git checkout master
    git branch --delete --force $BRANCH
    git push --no-verify origin --delete $BRANCH
else
    echo "Usage:"
    echo "'$0 init [session-name]'  # initialize a new mob session"
    echo "'$0 start [session-name]' # start your turn on a mob session"
    echo "'$0 next [session-name]'  # handover the mob session to the next person"
    echo "'$0 reset [session-name]' # reset the mob session"
fi
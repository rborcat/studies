#!bin/bash

echo -e "\n>> Updating git repositories.."

for d in */ ; do
    cd "$d"
    echo -e "\n>> Updating projects related to: $d"   
 
    for sd in */ ; do
        if [ -d $sd ] ; then
            cd "$sd"
            echo -e "\n>> Updating master branch: $sd"
            git checkout master
            git pull

            cd ..
       fi
    done

    cd ..
done

echo -e "\n>> Finished repositories update at $(date)!\n"

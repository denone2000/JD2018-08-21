#!/bin/bash

for f in `ls ./ | grep ".txt"`
do
  echo "Converting encoding of $f to ASCII..."
	native2ascii $f ../${f/.txt/.properties}
done

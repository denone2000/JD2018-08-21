#!/bin/bash

for f in `ls ./ | grep ".txt"`
do
  echo "Converting encoding of $f to ASCII..."
	native2ascii $f ../resources/${f/.txt/.properties}
done

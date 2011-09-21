#!/bin/bash

# make clean
make epub
make latex

cd _build/latex
xelatex *.tex
xelatex *.tex

cd ..
cd ..

cp -f _build/latex/*.pdf free/
cp -f _build/epub/*.epub free/

open free/*.pdf

make clean

FOR %%I In (*.txt) DO (
"/home/marina/courses/usr/java/jdk1.8.0_181-amd64/bin/native2ascii.exe" -encoding utf-8 %%I ..\res\%%~nI.properties
)

@echo off
:: Switch code page to UTF-8
chcp 65001 >nul

:: Set a font that supports Unicode (Cascadia Code, Consolas, etc. must be set manually in terminal)
:: Run Java with UTF-8 encoding
java -Dfile.encoding=UTF-8 -jar WizardGame.jar

:: Wait for user to see output
pause
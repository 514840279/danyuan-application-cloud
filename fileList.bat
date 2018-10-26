@echo off & setlocal EnableDelayedExpansion  
for /f "delims=" %%i in ('"dir /a/s/b/on *.*"') do (  
	set file=%%~fi,%%~di,%%~pi,%%~ni,%%~xi,%%~ti,%%~zi
	set file=!file:/=/! 
	if "%%~ni" == ""  (
		echo "none"
	)else (
		if "%%~xi" == ""  (
			echo "none"
		)else (
			
			if "%%~xi" == ".git"  (
				echo "none"
			)else (
				 echo !file!  >> list2.csv  
			)
			
		)
	)
		
	
)
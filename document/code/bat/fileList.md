# fileList

这一段代码用于数据目录中所有文件的 路径，盘符，文件名，文件类型，文件大小，创建日期输出到 list2.csv中
其中：

1. %%~fi 文件路径
2. %%~di 盘符
3. %%~pi 路径不带盘符
4. %%~ni 文件名称
5. %%~xi 文件扩展名
6. %%~ti 文件创建时间
7. %%~zi 文件大小

```
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
```
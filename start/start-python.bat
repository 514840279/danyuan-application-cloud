@echo off
 set _title=start-python
 ::设置标题文字
 title %_title%
 ::设置背景黑色，字体浅绿色
 color 0A
 echo ================================================================================
if "%1" == "h" goto begin 
mshta vbscript:createobject("wscript.shell").run("""%~nx0"" h",0)(window.close)&&exit 
:begin
cd ..
cd danyuan-application-crawler-python
python web.py
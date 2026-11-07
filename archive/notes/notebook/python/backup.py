import os
import time

#待压缩的源目录
source=['C:\\plugin-com.fr.plugins.barchart']

#压缩包存储的位置
target_dir='D:\\BackupCode'

target=target_dir+os.sep+\
       time.strftime('%Y%m%d%H%M%S')+'.zip'

if not os.path.exists(target_dir):
   os.mkdir(target_dir)

zip_command='zip -r {} {}'.format(target,' '.join(source))

print 'Zip command is: '
print zip_command
print 'Runnina:'
if os.system(zip_command) == 0:
   print 'Successful backup to',target
else:
   print 'backup failed'



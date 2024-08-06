from load_predict import predict
import pandas as pd
import numpy as np

# 获取数据
data = pd.read_csv('D:/IDE/pycharm_Project/pythonProject2/test/data.csv', encoding="utf-8")

# 不同的农作物
cocoa_beans = data[:39]
Oil_palm_fruit = data[39:78]
Rice_paddy = data[78:117]
Rubber_natural = data[117:]


which = int(input("请输入对应的数字选择作物的种类( 1.cocoa_beans 2.Oil_palm_fruit 3.Rice_paddy 4.Rubber_natural ):"))
# 当前的作物种类
crop = cocoa_beans
kind = 'cocoa_beans'
if which == 2:
    crop = Oil_palm_fruit
    kind = 'Oil_palm_fruit'
elif which == 3:
    crop = Rice_paddy
    kind = 'Rice_paddy'
elif which == 4:
    crop = Rubber_natural
    kind = 'Rubber_natural'
elif which != 1:
    print('无效输入')
    exit(0)

crop = pd.DataFrame(crop)
crop = np.array(crop.drop('Crop', axis=1))
# print(crop)
crop = np.split(crop, [4, 5], axis=1)

# 湿度数据
x = crop[0]
# print(x)

# 产量
y = crop[1]
# print(y)

pre1 = predict(f'model_of_{kind}.h5', x)

print(f'神经网络的预测产量: \n{pre1} ')
print(f'实际产量: \n{y}')


# 评估模型
# 平均绝对误差
pre = pre1
even_absolute = np.mean(np.absolute(pre-y))
print('平均绝对误差: ', even_absolute)

#定义准确度=(1-平均绝对误差/平均值)*100%
accuracy = '%.3f'%(100-100*even_absolute/np.mean(pre))
print(f'准确度: {accuracy}%')
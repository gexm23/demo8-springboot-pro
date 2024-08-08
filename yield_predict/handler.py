import argparse
from load_predict import predict

# 创建argumentParser对象
parser = argparse.ArgumentParser(description='产量预测模型')

# 添加参数
parser.add_argument('echo', nargs='+', help='回显输入的字符串')
# 解析参数
args = parser.parse_args()

data = [0, 0, 0, 0]
location = args.echo[0]

for i in range(len(data)):
    data[i] = float(args.echo[i+1])

print(predict(location, data))
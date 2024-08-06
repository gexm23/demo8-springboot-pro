from keras.models import load_model

# 规范化函数
def scale_x(x):
    x_scaled = x/10
    x_scaled[:, 0] = x_scaled[:, 0]/100
    return x_scaled

def inverse_y(y_scaled):
    return y_scaled*1000

# 根据数据进行预测,name为模型文件的名字,data为与训练模型所用数据格式一致的数据
def predict(name, data):

    # 规范化
    data_scaled = scale_x(data)

    # 导入model
    loaded_model = load_model(name)

    # 预测
    return inverse_y(loaded_model.predict(data_scaled))

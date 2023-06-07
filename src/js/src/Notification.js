import {notification} from 'antd';

const openNotification = (message, description) => {
    notification.open({
        message,
        description,
        onClick: () => {
            console.log('Notification Clicked!');
        },
    });
};

export const successNotification = (message, description) => {
    openNotification(message, description);
}

export const infoNotification = (message, description) => {
    openNotification(message, description);
}

export const warningNotification = (message, description) => {
    openNotification( message, description);
}

export const errorNotification = (message, description) => {
    openNotification( message, description);
}
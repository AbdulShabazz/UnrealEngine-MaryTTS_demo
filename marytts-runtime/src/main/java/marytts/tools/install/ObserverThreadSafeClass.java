package marytts.tools.install;

//import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ObserverThreadSafeClass<T> {
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private T data;

    public T GetData() {
        return data;
    }

    public synchronized void SetDataAndFirePropertyChange(T newData) {
        T oldData = this.data;
        this.data = newData;
        support.firePropertyChange("data", oldData, newData);
    }

    public synchronized void AddPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public synchronized void RemovePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}

/* 
Example of use:

public class ObserverClass implements PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if ("data".equals(event.getPropertyName())) {
            System.out.println("Data has changed - old: " + event.getOldValue() + ", new: " + event.getNewValue());
        }
    }

    public static void main(String[] args) {
        // Create an instance of ObserverClass
        ObserverClass observable = new ObserverClass(); 

        // Create an instance of ObserverClass and add it as a listener
        ObserverClass observer = new ObserverClass();
        observable.addPropertyChangeListener(observer);

        // Modify data to observe the changes
        observable.setData(5);
        observable.setData(10);
        observable.setData(20);
    }
} */

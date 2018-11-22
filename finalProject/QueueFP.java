/**
 * This package groups all of the files for the final project.
 */
package finalProject;

/**
 * The purpose of this class is to create and modify a queue.
 * 
 * @author Samantha Lange
 *
 */
public class QueueFP {
	// fields
	private int sizeOfQueue; 
	private Patient[] queueArray;
	private int front;
	private int rear;
	private int patientsInQueue;
	
	/**
	 * This constructor creates an empty array queue.
	 * 
	 * @param size	the size of the queue
	 */
	public QueueFP(int size) {
		this.sizeOfQueue = size;
		this.front = 0;
		this.rear = -1;
		this.patientsInQueue = 0;
		this.queueArray = new Patient[sizeOfQueue];
	}
	
	/**
	 * This method returns the patient at the front of the queue.
	 * 
	 * @return	the patient at the front of the queue
	 */
	public Patient peek() {
		return queueArray[front];
	}
	
	/**
	 * This method adds patient to the queue
	 * if the queue is not full.
	 * 
	 * @param pat	the patient to be added to the queue
	 */
	public void enqueue(Patient pat) {
		if(!isFull())
		{
			if(rear == sizeOfQueue - 1)
			{
				rear = -1;
			}
			queueArray[++rear] = pat;
			patientsInQueue++;
		}
	}
	
	/**
	 * This method removes the patient at the front of the queue.
	 * 
	 * @return	the patient at the front of the queue
	 */
	public Patient dequeue() {
		Patient pat = null;
		if(!isEmpty())
		{
			pat = queueArray[front++];
			if(front == sizeOfQueue)
			{
				front = 0;
			}
			patientsInQueue--;
		}
		return pat; 
	}
	
	/**
	 * This method returns the number of patients in the queue.
	 * 
	 * @return	the number of patients in the queue
	 */
	public int size() {
		return patientsInQueue;
	}
	
	/**
	 * This method checks to see if the queue is empty.
	 * If empty, returns true.
	 * 
	 * @return	true if queue is empty
	 */
	public boolean isEmpty() {
		return (patientsInQueue == 0);
	}
	
	/**
	 * This method checks to see if the queue is full.
	 * If full, returns true.
	 * 
	 * @return	true if queue is full
	 */
	public boolean isFull() {
		return (patientsInQueue == sizeOfQueue);
	}
	                                         // ****delete print method after testing ******
	/**
	 * This method prints the queue from front to rear.
	 */
	public void print() {
		if(!isEmpty())
		{
			if(rear == front)
			{
				System.out.println(queueArray[front].toString());
			}
			else
			{
				for (int i = front; i <= sizeOfQueue - 1; i++)
				{
					System.out.println(queueArray[i].toString());
				}
				if(rear < front)
				{
					for (int i = 0; i <= rear; i++)
					{
						System.out.println(queueArray[i].toString());
					}
				}
			}
		}
	}
}

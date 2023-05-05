package com.mycompany.app;

public class LinkedList<T>
{
    T data;
    LinkedList<T> next;

    public LinkedList(T data) 
    {
        this.data = data;
        this.next = null;
    }

    public void addNode(T data)
    {
        LinkedList<T> current = this;
        while (current.next != null)
        {
            current = current.next;
        }

        current.next = new LinkedList<T>(data);
    }

    public void removeNode(T data)
    {
        LinkedList<T> previous = null;
        LinkedList<T> current = this;
        
        while (current != null)
        {
            if (current.data.equals(data))
            {
                if (current.next == null)
                {
                    previous.next = current.next;
                }
            }

            previous = current;
            current = current.next;
        }
    }

    public void printList(LinkedList<T> list)
    {
        while (list != null)
        {
            System.out.println("List data: " + list.data);
            list = list.next;
        }
    }
}

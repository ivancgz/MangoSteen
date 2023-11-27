package com.mangosteen.app.mockito;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class DemoTest {
    @Test
    void testList() {
        List<String> mockList = mock();

        when(mockList.get(5)).thenReturn("five");
        when(mockList.get(10)).thenThrow(new IndexOutOfBoundsException("Out of bound!"));

        // 不会真正调用方法本身，适用于方法有副作用的情况
        doReturn("one").when(mockList).get(1);
        doThrow(new IndexOutOfBoundsException("Out of index.")).when(mockList).get(6);

        System.out.println(mockList.get(5));
        System.out.println(mockList.get(5));
        System.out.println(mockList.get(1));
//        System.out.println(mockList.get(6));
//        System.out.println(mockList.get(10));

        // verify() 验证模拟对象方法调用的情况
        verify(mockList, times(2)).get(eq(5));
        verify(mockList, atMostOnce()).get(eq(1));
//        verify(mockList, times(3)).get(anyInt());
//        verify(mockList, times(3)).get(5);
//        verify(mockList).get(1); // times: 1
        verify(mockList, never()).get(10);
    }
}

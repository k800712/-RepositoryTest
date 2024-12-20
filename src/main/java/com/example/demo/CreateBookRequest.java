package com.example.demo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public record CreateBookRequest(@Size(min = 2, max = 50) String title,
                                @Size(min = 2, max = 30) String author,
                                @Size(min = 13,max = 13) String isbn,
                                @Min(0) Integer price,
                                @Min(1900)@Max(2024) Integer publishedYear) {

}

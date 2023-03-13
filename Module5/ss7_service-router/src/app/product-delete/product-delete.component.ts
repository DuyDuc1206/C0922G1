import {Component, OnInit} from '@angular/core';
import {ProductService} from '../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Product} from '../model/product';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {
  productDelete: Product = null;
  productDeleteForm: FormGroup;
  id: number;

  constructor(private productService: ProductService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(paraMap => {
      this.id = +paraMap.get('id');
      this.productDelete = this.productService.findById(this.id);
    });
    this.productDeleteForm = new FormGroup({
      id: new FormControl(this.productDelete.id),
      name: new FormControl(this.productDelete.name),
      price: new FormControl(this.productDelete.price,),
      description: new FormControl(this.productDelete.description),
    });
  }

  onDelete() {
    this.productService.delete(this.id);
    this.router.navigateByUrl('/product');
  }
}

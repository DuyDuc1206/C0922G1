import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {TimelinesComponent} from './timelines/timelines.component';
import {YoutubePlaylistComponent} from './youtube-playlist/youtube-playlist.component';
import {YoutubePlayerComponent} from './youtube-player/youtube-player.component';
import {DictionaryPageComponent} from './dictionary-page/dictionary-page.component';
import {DictionaryDetailComponent} from './dictionary-detail/dictionary-detail.component';
import {ProductPageComponent} from './product-page/product-page.component';
import {ProductDetailComponent} from './product-detail/product-detail.component';
import {ProductCreateComponent} from './product-create/product-create.component';
import {ProductUpdateComponent} from './product-update/product-update.component';
import {ProductDeleteComponent} from './product-delete/product-delete.component';


const routes: Routes = [
  {path: '', component: TimelinesComponent},
  {
    path: 'song', component: YoutubePlaylistComponent, children: [{
      path: ':id', component: YoutubePlayerComponent
    }]
  },
  {path: 'dictionary', component: DictionaryPageComponent},
  {path: 'dictionary/detail/:word', component: DictionaryDetailComponent},
  {path: 'product', component: ProductPageComponent},
  {path: 'product/detail/:id', component: ProductDetailComponent},
  {path: 'product/create', component: ProductCreateComponent},
  {path: 'product/update/:id', component: ProductUpdateComponent},
  {path: 'product/delete/:id', component: ProductDeleteComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

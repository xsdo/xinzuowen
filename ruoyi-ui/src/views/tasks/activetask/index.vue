<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="是否使用" prop="isUsed">
        <el-input
          v-model="queryParams.isUsed"
          placeholder="请输入是否使用"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="备注" prop="remarks">
        <el-input
          v-model="queryParams.remarks"
          placeholder="请输入备注"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="活动名" prop="acName">
        <el-input
          v-model="queryParams.acName"
          placeholder="请输入活动名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="活动简介" prop="acSynopsis">
        <el-input
          v-model="queryParams.acSynopsis"
          placeholder="请输入活动简介"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="活动奖励" prop="acAward">
        <el-input
          v-model="queryParams.acAward"
          placeholder="请输入活动奖励"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="活动开启时间" prop="acBegintime">
        <el-date-picker clearable
          v-model="queryParams.acBegintime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择活动开启时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="活动结束时间" prop="acEndtime">
        <el-date-picker clearable
          v-model="queryParams.acEndtime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择活动结束时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="是否付费" prop="acIspay">
        <el-input
          v-model="queryParams.acIspay"
          placeholder="请输入是否付费"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['tasks:activetask:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['tasks:activetask:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['tasks:activetask:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['tasks:activetask:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="activetaskList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="是否使用" align="center" prop="isUsed" />
      <el-table-column label="备注" align="center" prop="remarks" />
      <el-table-column label="活动名" align="center" prop="acName" />
      <el-table-column label="活动简介" align="center" prop="acSynopsis" />
      <el-table-column label="活动状态" align="center" prop="acStatus" />
      <el-table-column label="活动类型" align="center" prop="acType" />
      <el-table-column label="活动奖励" align="center" prop="acAward" />
      <el-table-column label="活动图" align="center" prop="acImage" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.acImage" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="活动开启时间" align="center" prop="acBegintime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.acBegintime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="活动结束时间" align="center" prop="acEndtime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.acEndtime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="是否付费" align="center" prop="acIspay" />
      <el-table-column label="活动文案" align="center" prop="acPaperwork" />
      <el-table-column label="活动地址" align="center" prop="acUrl" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['tasks:activetask:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['tasks:activetask:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改活动任务对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="是否使用" prop="isUsed">
          <el-input v-model="form.isUsed" placeholder="请输入是否使用" />
        </el-form-item>
        <el-form-item label="备注" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="活动名" prop="acName">
          <el-input v-model="form.acName" placeholder="请输入活动名" />
        </el-form-item>
        <el-form-item label="活动简介" prop="acSynopsis">
          <el-input v-model="form.acSynopsis" placeholder="请输入活动简介" />
        </el-form-item>
        <el-form-item label="活动奖励" prop="acAward">
          <el-input v-model="form.acAward" placeholder="请输入活动奖励" />
        </el-form-item>
        <el-form-item label="活动图" prop="acImage">
          <image-upload v-model="form.acImage"/>
        </el-form-item>
        <el-form-item label="活动开启时间" prop="acBegintime">
          <el-date-picker clearable
            v-model="form.acBegintime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择活动开启时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="活动结束时间" prop="acEndtime">
          <el-date-picker clearable
            v-model="form.acEndtime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择活动结束时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="是否付费" prop="acIspay">
          <el-input v-model="form.acIspay" placeholder="请输入是否付费" />
        </el-form-item>
        <el-form-item label="活动文案" prop="acPaperwork">
          <el-input v-model="form.acPaperwork" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="活动地址" prop="acUrl">
          <el-input v-model="form.acUrl" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listActivetask, getActivetask, delActivetask, addActivetask, updateActivetask } from "@/api/tasks/activetask";

export default {
  name: "Activetask",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 活动任务表格数据
      activetaskList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        isUsed: null,
        remarks: null,
        acName: null,
        acSynopsis: null,
        acStatus: null,
        acType: null,
        acAward: null,
        acImage: null,
        acBegintime: null,
        acEndtime: null,
        acIspay: null,
        acPaperwork: null,
        acUrl: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询活动任务列表 */
    getList() {
      this.loading = true;
      listActivetask(this.queryParams).then(response => {
        this.activetaskList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        isUsed: null,
        createTime: null,
        updateTime: null,
        remarks: null,
        acName: null,
        acSynopsis: null,
        acStatus: null,
        acType: null,
        acAward: null,
        acImage: null,
        acBegintime: null,
        acEndtime: null,
        acIspay: null,
        acPaperwork: null,
        acUrl: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加活动任务";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getActivetask(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改活动任务";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateActivetask(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addActivetask(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除活动任务编号为"' + ids + '"的数据项？').then(function() {
        return delActivetask(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('tasks/activetask/export', {
        ...this.queryParams
      }, `activetask_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
